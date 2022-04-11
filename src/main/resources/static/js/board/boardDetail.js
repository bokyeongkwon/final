'use strict';

// 닉네임 클릭 시
const $nickname = document.querySelector('.top_ul_nickname');
  $nickname.addEventListener('click', e=>{
    let $menu = document.querySelector('.side_med');
    if($menu.style.display == 'none'){
         $menu.style.display = 'block';
    }else{
         $menu.style.display = 'none';
    }
  });

// 좋아요 클릭 시
const $heart = document.querySelector('.top_ul i');
  $heart.addEventListener('click', e=>{
    const url = `/board/`
  });

// 조회 수 옆 아이콘 클릭 시
const $boardIcon = document.querySelector('.menu_icon');
  $boardIcon.addEventListener('click', e=>{
    console.log('클릭됨');
    let $menu = document.querySelector('.side_menu_list');
    if($menu.style.display == 'none'){
         $menu.style.display = 'block';
    }else{
         $menu.style.display = 'none';
    }
  });

// 신고 버튼 클릭 시
//const $report = document.querySelector('.reportBtn');
//  $report.addEventListener('click', e=>{
//    const report = e.target.dataset.reportNum;
//    location.href = ``;
//  });



// 게시물 수정 버튼 클릭 시
//const $boardUpdate = document.getElementById('boardUBtn');
// $boardUpdate.addEventListener('click', e=>{
//  location.href = `/board/${boardNum}/edit`;
// });


// 게시물 삭제 버튼 클릭 시
const $boardDelete = document.getElementById('boardDBtn');
if($boardDelete){
  $boardDelete.addEventListener('click', e=>{
    const cateNum = e.target.dataset.cateNum;
    const boardNum = e.target.dataset.boardNum;
    const url = `/board/${boardNum}`;
    console.log(url);
    request.delete(url)
    .then(res=>res.json())
    .then(res=>{
          if(res.rtce == '00'){
            if(confirm("게시글을 삭제하시겠습니까?")) location.href=`/board/${cateNum}`;
          }else{
            alert(res.rtmsg);
          }
          throw new Error(res.rtmsg);
    })
    .catch(err=>{
      //오류 로직 처리
      console.log(err.message);
    });
  });
}


// 댓글 등록 버튼 클릭 시
const $insertReply = document.querySelector('.replyBtn');
  $insertReply.addEventListener('click', e=>{
    console.log('클릭됨!');

    const $replyContent = document.getElementById('replyTextArea');
    const boardNum = e.target.dataset.boardNum;
    const cateNum = e.target.dataset.cateNum;

    if($replyContent.value.trim().length == 0 ){
      alert('댓글 내용을 입력해주세요.');
      $replyContent.focus();
      $replyContent.select();
      return;
    }
    location.href = `/board/${boardNum}/reply?cateNum=${cateNum}`;

  });

// 댓글 아이콘 클릭 시
const $replyIcon = document.querySelector('.icon');
  $replyIcon.addEventListener('click', e=>{
    console.log('클릭됨');
    let $menu = document.querySelector('.replyMenu');
    if($menu.style.display == 'none'){
         $menu.style.display = 'block';
    }else{
         $menu.style.display = 'none';
    }
  });



// 댓글 수정 버튼 클릭 시
//const $replyUpdate = document.getElementById('replyUBtn');
//  $replyUpdate.addEventListener('click', e=>{
//
//  });


// 댓글 삭제 버튼 클릭 시
const $replyDelete = document.getElementById('replyDBtn');
if($replyDelete){
  $replyDelete.addEventListener('click', e=>{
    const cateNum = e.target.dataset.cateNum;
    const boardNum = e.target.dataset.boardNum;
    request.delete(replyNum)
    .then(res=>res.json())
    .then(res=>{
          if(res.rtce == '00'){
            if(confirm("댓글을 삭제하시겠습니까?")) location.href=`/board/${boardNum}/detail?cateNum=${cateNum}`;
          }else{
            alert(res.rtmsg);
          }
          throw new Error(res.rtmsg);
    })
    .catch(err=>{
      //오류 로직 처리
      console.log(err.message);
    });
  });
}