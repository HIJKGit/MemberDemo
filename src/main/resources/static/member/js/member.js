(() => {
    const li_img = document.querySelector('.ul-list').querySelector('#li-img');
    if (li_img) {
        const img = document.createElement('img');
        img.src = `${getContextPath()}/index/img/springlogo.png`;
        img.width = '70';
        img.height = '70';
        li_img.append(img);
    }

    function getContextPath() {
        return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
    }
})();