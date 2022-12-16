(() => {
  const username = document.querySelector('#username');
  const oPassword = document.querySelector('#oPassword');
  const nPassword = document.querySelector('#nPassword');
  const cPassword = document.querySelector('#confirmPassword');
  const nickname = document.querySelector('#nickname');
  const lastUpdatedDate = document.querySelector('#lastUpdatedDate')
  const image = document.querySelector('#image');
  const preImg = document.querySelector('#previewImg');
  const btn = document.querySelector('#edit_btn');
  const btn2 = document.querySelector('#upload_btn');
  const msg = document.querySelector('#errMsg')
  init();

  function init() {
    btn.addEventListener('click', edit);

    fetch('edit')
      .then(resp => resp.json())
      .then(body => {
        lastUpdatedDate.value = body['lastUpdatedDate'];
        username.value = body['username'];
        nickname.value = body['nickname'];
        const imageBinaryStr = atob(body['image']);
        let len = imageBinaryStr.length;

        const uint8Array = new Uint8Array(len);
        while (len--) {
          uint8Array[len] = imageBinaryStr.charCodeAt(len);
        }
        const blob = new Blob([uint8Array]);
        preImg.src = URL.createObjectURL(blob);
      });

    oPassword.addEventListener('blur', checkOldPassword);
    image.addEventListener('change', onImageChange);
  }

  function onImageChange() {
    const file = image.files[0];
    if (file) {
      preImg.src = URL.createObjectURL(file);
      btn2.textContent = file.name;
    }
  }

  function checkOldPassword() {
    fetch(`edit/${oPassword.value || '_'}`)
      .then(resp => resp.json())
      .then(body => {
        btn.disabled = !body['successful']
      }
      )
  }

  function edit() {
    if(oPassword.value.length === 0){
      msg.textContent = '請輸入密碼';
      oPassword.focus();
      return;
    }
    if (nPassword.value && confirmPassword.value) {
      if (nPassword.value.length < 6 || nPassword.value.length > 12) {
        msg.textContent = '密碼長度須介於6~12字元';
        return;
      }

      if (cPassword.value !== nPassword.value) {
        msg.textContent = '密碼與確認密碼不相符';
        return;
      }
    }

    const nicknameLength = nickname.value.length;
    if (nicknameLength < 1 || nicknameLength > 20) {
      msg.textContent = '暱稱長度須介於1~20字元';
      return;
    }

    msg.textContent = '';

    if (image.files.length === 0) {
      requestEdit();
    } else {
      file2Base64Str(requestEdit);
    }

    function requestEdit(imageBase64) {
      fetch('edit', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          password: nPassword.value,
          nickname: nickname.value,
          image: imageBase64
        }),
      })
        .then(resp => resp.json())
        .then(body => {
          const { successful, message, nickname: nicknameValue, image: imageValue } = body;
          if (successful) {
            msg.className = 'info';
            sessionStorage.setItem('nickname', nicknameValue);
            // currentUser.textContent = nicknameValue;
            oPassword.value = '';
            nPassword.value = '';
            cPassword.value = '';
            nickname.value = nicknameValue;
            btn.disabled = true;
            sessionStorage.setItem('image', imageValue);
            base64Str2Avatar();
          } else {
            msg.className = 'error';
          }
          msg.textContent = message;
        });
    }

    function file2Base64Str(next) {
      const fileReader = new FileReader();
      fileReader.addEventListener('load', e => {
        const imageBase64 = btoa(e.target.result);
        next(imageBase64);
      });
      fileReader.readAsBinaryString(image.files[0]);
    }

    function base64Str2Avatar() {
      const img = sessionStorage.getItem('image');
      if (!img) {
        return;
      }
      const imageBinaryStr = atob(img);
      let len = imageBinaryStr.length;
      const uint8Array = new Uint8Array(len);
      while (len--) {
        uint8Array[len] = imageBinaryStr.charCodeAt(len);
      }
      const blob = new Blob([uint8Array]);
      preImg.src = URL.createObjectURL(blob);
    }
  }

})();