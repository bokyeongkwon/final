'use strict'

const $loginBtn = document.getElementById('loginBtn');
$loginBtn?.addEventListener("click", e=>{

    const $id = document.getElementById('id');
    const $pw = document.getElementById('pw');

    if(!$id.value){
        alert('아이디를 입력 바랍니다');
        $id.focus();
        $id.select();
        return;
    }else if(!$pw.value){
             alert('비밀번호를 입력 바랍니다');
             $pw.focus();
             $pw.select();
             return;
         }

  loginForm.submit();
  const url = `/`;
  location.href = url;
  console.log('로그인제출성공');
  });