(() => {
    const username = document.querySelector('#username');
    const password = document.querySelector('#password');
    const confirmPassword = document.querySelector('#confirmPassword');
    const nickname = document.querySelector('#nickname');
    const image = document.querySelector('#image');
    const msg = document.querySelector('#errMsg');
    const btn = document.querySelector('#reg_btn');
    const inputs = document.querySelectorAll('input');
    const img = document.querySelector('#previewImg');
    const btn2 = document.querySelector('#upload_btn');
    image.addEventListener('change', () => {
        const file = image.files[0];
        if (file) {
            img.src = URL.createObjectURL(file);
            btn2.textContent = ' ' + file.name;
        }
    });

    document.querySelector('#reg_btn').addEventListener('click', () => {
        const accLength = username.value.length;
        if (accLength < 6 || accLength > 20) {
            msg.textContent = '帳號長度須介於6~20字元';
            username.focus();
            return;
        }

        const pwdLength = password.value.length;
        if (pwdLength < 6 || pwdLength > 20) {
            msg.textContent = '密碼長度須介於6~20字元';
            password.focus();
            return;
        }

        if (confirmPassword.value != password.value) {
            msg.textContent = '密碼與確認密碼不相符';
            confirmPassword.focus();
            return;
        }

        const nicknameLength = nickname.value.length;
        if (nicknameLength < 1 || nicknameLength > 20) {
            msg.textContent = '暱稱長度須介於1~20字元';
            nickname.focus();
            return;
        }


        if (!image.files[0]) {
            msg.textContent = '請上傳頭像';
            btn2.focus();
            return;
        }
        msg.textContent = '';
        const fileReader = new FileReader();
        fileReader.addEventListener('load', e => {
            const imageBase64 = btoa(e.target.result);
            fetch('register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    username: username.value,
                    password: password.value,
                    nickname: nickname.value,
                    image: imageBase64
                }),
            })
                .then(resp => resp.json())
                .then(body => {
                    const { successful, message } = body;
                    if (successful) {
                        for (let input of inputs) {
                            input.disabled = true;
                        }
                        btn.disabled = true;
                        msg.className = 'info';
                        msg.textContent = message;
                    } else {
                        msg.className = 'error';
                        msg.textContent = '註冊失敗：' + message;
                    }
                });
        });
        const file = image.files[0];
        if (file)
            fileReader.readAsBinaryString(file);
    });
})();

