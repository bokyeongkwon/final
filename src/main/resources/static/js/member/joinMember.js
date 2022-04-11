'use strict';

       //유효성 체크 상태
        const validChkStatus = {
            id:false,
            email:false,
            nickname:false
        }

        //아이디 중복 확인
        const $id = document.getElementById('id');
        const $idDubChk = document.getElementById('idDubChk');

        $idDubChk.addEventListener('click', e=>{
          const $errmsg = $idDubChk.closest('div').querySelector('.errmsg');
          if(!$id.value){
            $errmsg.textContent = '아이디를 입력하세요';
            $id.select();$id.focus();
            return false;
          }

            const xmlHttpreq = new XMLHttpRequest();

            const url = `/api/member/${$id.value}/exist`;
            xmlHttpreq.open("GET", url);
            xmlHttpreq.send();

            xmlHttpreq.addEventListener('load', e=>{
                if(xmlHttpreq.status === 200){
//                    console.log(xmlHttpreq.response);
                    const result = JSON.parse(xmlHttpreq.response);
//                    console.log(result);
                    const $errmsg = $idDubChk.closest('div').querySelector('.errmsg');

                    if(result.rtcd === '00'){
                        $errmsg.textContent = '이미 사용 중인 아이디 입니다.';
                        $errmsg.style.display = 'block';
                    }else{
                        $errmsg.textContent = '';
                        $errmsg.style.display = 'none';
                        $idDubChk.textContent = '사용가능';
                        $idDubChk.disabled = 'disabled';
                        validChkStatus.id = true;
                    }
                }else{
                    console.log('Error', xmlHttpreq.status, xmlHttpreq.statusText);
                }
            });
        });

        //이메일 중복 확인
        const $email = document.getElementById('email');
        const $emailDubChk = document.getElementById('emailDubChk');

        $emailDubChk.addEventListener('click', e=>{
          const $errmsg = $emailDubChk.closest('div').querySelector('.errmsg');
          if(!$email.value){
            $errmsg.textContent = '이메일을 입력하세요';
            $email.select();$email.focus();
            return false;
          }

            const xmlHttpreq = new XMLHttpRequest();

            const url = `/api/member/email/${$email.value}/exist`;
            xmlHttpreq.open("GET", url);
            xmlHttpreq.send();

            xmlHttpreq.addEventListener('load', e=>{
                if(xmlHttpreq.status === 200){
//                    console.log(xmlHttpreq.response);
                    const result = JSON.parse(xmlHttpreq.response);
//                    console.log(result);
                    const $errmsg = $emailDubChk.closest('div').querySelector('.errmsg');

                    if(result.rtcd === '00'){
                        $errmsg.textContent = '이미 사용 중인 이메일 입니다.';
                        $errmsg.style.display = 'block';
                    }else{
                        $errmsg.textContent = '';
                        $errmsg.style.display = 'none';
                        $emailDubChk.textContent = '사용가능';
                        $emailDubChk.disabled = 'disabled';
                        validChkStatus.email = true;
                    }
                }else{
                    console.log('Error', xmlHttpreq.status, xmlHttpreq.statusText);
                }
            });
        });

        //닉네임 중복 확인
        const $nickname = document.getElementById('nickname');
        const $nicknameDubChk = document.getElementById('nicknameDubChk');

        $nicknameDubChk.addEventListener('click', e=>{
          const $errmsg = $nicknameDubChk.closest('div').querySelector('.errmsg');
          if(!$nickname.value){
            $errmsg.textContent = '닉네임을 입력하세요';
            $nickname.select();$nickname.focus();
            return false;
          }
            const xmlHttpreq = new XMLHttpRequest();

            const url = `/api/member/nickname/${$nickname.value}/exist`;
            xmlHttpreq.open("GET", url);
            xmlHttpreq.send();

            xmlHttpreq.addEventListener('load', e=>{
                if(xmlHttpreq.status === 200){
//                    console.log(xmlHttpreq.response);
                    const result = JSON.parse(xmlHttpreq.response);
//                    console.log(result);
                    const $errmsg = $nicknameDubChk.closest('div').querySelector('.errmsg');

                    if(result.rtcd === '00'){
                        $errmsg.textContent = '이미 사용 중인 닉네임 입니다.';
                        $errmsg.style.display = 'block';
                    }else{
                        $errmsg.textContent = '';
                        $errmsg.style.display = 'none';
                        $nicknameDubChk.textContent = '사용가능';
                        $nicknameDubChk.disabled = 'disabled';
                        validChkStatus.nickname = true;
                    }
                }else{
                    console.log('Error', xmlHttpreq.status, xmlHttpreq.statusText);
                }
            });
        });

        //회원가입 버튼 클릭시
        joinBtn.addEventListener('click', e=>{

            console.log("클릭됨!");
            //아이디 중복체크 미이행시
            if(!validChkStatus.id){
                alert('아이디 중복체크 바랍니다');
                $id.focus();
                $id.select();
                return;
            }

            //이메일 중복체크 미이행시
            if(!validChkStatus.email){
                alert('이메일 중복체크 바랍니다');
                $email.focus();
                $email.select();
                return;
            }

            //별칭 중복체크 미이행시
            if(!validChkStatus.nickname){
                alert('닉네임 중복체크 바랍니다');
                $nickname.focus();
                $nickname.select();
                return;
            }
            alert('회원가입이 완료되었습니다!');
            joinMember.submit();
        });