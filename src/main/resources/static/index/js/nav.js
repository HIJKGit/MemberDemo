(() => {
  const nav = document.createElement('nav');
  nav.classList.add('navbar', 'navbar-expand-lg', 'ftco_navbar', 'ftco-navbar-light', 'navbar-dark', 'bg-dark');
  nav.id = 'ftco-navbar';
  nav.innerHTML =
  `<div class="container" id="navbar">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
  aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
  <span class="fa fa-bars"></span> Menu
  </button>
  <form action="#" class="searchform order-lg-last">
  <div class="form-group d-flex">
  <input type="search" class="form-control pl-3 search_input" placeholder="Search" id="search_input">
  <button type="button" placeholder="" class="form-control search" id="search_btn">
  <span class="fa fa-search"></span></button>
  </div>
  </form>
  <div class="collapse navbar-collapse" id="ftco-nav">
  <ul class="navbar-nav mr-auto">
  <li class="nav-item active"><a href="${getContextPath()}/" class="nav-link" aria-current="page">Home</a></li>
  <li class="nav-item active"><a href="#" class="nav-link">Blog</a></li>
  <li class="nav-item active hide" id="edit"><a href="${getContextPath()}/member/edit.html" class="nav-link" aria-current="page">編輯個人資訊</a></li>
  <li class="nav-item active hide" id="manage"><a href="${getContextPath()}/member/manage" class="nav-link" aria-current="page">管理會員</a></li>
  <li class="nav-item active" id="login"><a href="${getContextPath()}/member/login.html" class="nav-link" aria-current="page">登入/註冊</a></li>
  <li class="nav-item active hide" id="logout"><a href="#" class="nav-link" aria-current="page">登出</a></li>
  </ul>
  </div>
  </div>`;
  const body = document.querySelector('body');
  body.insertBefore(nav, body.firstChild);

  // const head = document.querySelector('head');
  // const link = document.createElement('link')
  // link.rel = 'stylesheet';
  // link.href= `${getContextPath()}/index/css/styles.css`;
  // head.append(link)
  const search_input = document.querySelector('#search_input');
  const search_btn = document.querySelector('#search_btn');
  search_btn.addEventListener('click', () => {
    if(search_input.value == ""){
      alert('輸入內容為空')
      return;
    }
    fetch(`${getContextPath()}/member/search/${search_input.value}`)
    .then(resp => resp.json())
    .then(body => {
      const { successful, message} = body;
      if(successful){
        // const { id, username, nickname, roleId, image, pass, lastUpdatedDate} = body;
        alert(message);
      }else{
        alert(message);
      }
    })
  })
  /************************************************
   *                  nav-item                    *
   ************************************************/
  const login = document.querySelector('#login')
  const logout = document.querySelector('#logout')
  const edit = document.querySelector('#edit');
  const manage = document.querySelector('#manage');
  const nickname = sessionStorage.getItem('nickname');
  const roleId = sessionStorage.getItem('roleId');
  if(nickname){
    login.classList.add('hide');
    edit.classList.remove('hide');
    roleId == 1 ? manage.classList.remove('hide') : manage.style = 'display:none;';
    logout.classList.remove('hide');
  }else{
    login.classList.remove('hide');
    edit.classList.add('hide');
    logout.classList.add('hide');
  }

  logout.addEventListener('click', () => {
    sessionStorage.removeItem('nickname');
    fetch('member/logout');
    location = `${getContextPath()}`;
  })
  function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
  }
})();