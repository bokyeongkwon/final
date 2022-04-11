'use strict';
        //값 가지고오기용 입력창
        const $memberNum = document.getElementById('memberNum');
        const $gender = document.getElementById('gender');



        //탈퇴버튼
        const $outBtn = document.getElementById('outBtn');

        //입력버튼
        const $pw = document.getElementById('pw');
        const $tel = document.getElementById('tel');
        const $birth = document.getElementById('birth');
        const $email = document.getElementById('email');
        const $nickname = document.getElementById('nickname');

        //수정버튼
        const $pwd_modify_Btn = document.querySelector('.pwd_modify');
        const $phone_modify_Btn = document.querySelector('.phone_modify');
        const $birth_modify_Btn = document.querySelector('.birth_modify');
        const $email_modify_Btn = document.querySelector('.email_modify');
        const $nickname_modify_Btn = document.querySelector('.nickname_modify');

        //중복확인 버튼
        const $nickname_chk_Btn = document.querySelector('.nickname_chk');

        //안보이는 입력창 나타나게 하기
        $pwd_modify_Btn.addEventListener('click', function (e) {
            $pw.style.display = 'inline';
        });
        $phone_modify_Btn.addEventListener('click', function (e) {
            $tel.style.display = 'inline';
        });
        $email_modify_Btn.addEventListener('click', function (e) {
            $email.style.display = 'inline';
        });
        $birth_modify_Btn.addEventListener('click', function (e) {
            $birth.style.display = 'inline';
        });
        $nickname_modify_Btn.addEventListener('click', function (e) {
            $nickname.style.display = 'inline';
            $nickname_chk_Btn.style.display = 'inline';
        });

        $outBtn.addEventListener('click', del_f);

        //회원탈퇴
        function del_f(e) {
            if (window.confirm("정말 탈퇴하시겠습니까?")) {
                const url = `/member/${memberNum.value}/del`;
                location.href = url;
            }
        }

        // //회원탈퇴
        // function del_f(e) {
        //     const url = `/api/member/{memberNum.value}`;
        //     fetch(url, {
        //         method: 'DELETE'
        //     }).then(res => res.json())
        //         .then(res => { console.log(res)})
        //         .catch(err => { console.error('Err:', err) });
        //         location.href = "/main";
        // }

        //성별값 숨겨준 input 값을 바꾸기
        function getGender(event) {
            document.getElementById('gender').value =
                event.target.value;
        }

        //라디오버튼 미리 틀어놓기
        function radio(e) {
            if ($gender.value == "여") {
                female.checked = true;
            }else{
                male.checked = true;
            }
        }
        radio();