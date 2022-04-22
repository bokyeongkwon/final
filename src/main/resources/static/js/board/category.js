// 현재 접속해있는 게시판의 카테고리 읽어오기.
const $main = document.querySelector('main');
const cateNum = ($main?.dataset.cateNum) ? $main.dataset.cateNum : '';

const $bakingClassWriteBtn = document.getElementById('bakingClassWriteBtn');
$bakingClassWriteBtn?.addEventListener('click', e => {
    location.href = `/board/add?cateNum=${cateNum}`;

});

const $writeBtn = document.getElementById('writeBtn');
$writeBtn?.addEventListener('click', e => {
    location.href = `/board/add?cateNum=${cateNum}`;

});