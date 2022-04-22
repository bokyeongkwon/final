'use strict';

//관심리스트 설정/해제
// .bookmark-container(상위 태그=parent container)위치에 체크박스를 생성한다
// 0) 상위 컨테이너 위치 타겟팅. 여기 아래로 추가.
const whereBookmark = document.querySelectorAll(".bookmark-container");

// 1) 요소 생성
const $label = document.createElement('label');
const $likeList = document.createElement('input');

const $checked = document.createElement('i');
const $unchecked = document.createElement('i');

// 2) label, input에 각각 속성 추가
$label.setAttribute('class', 'bookmark');

$likeList.setAttribute('type', 'checkbox');
$likeList.setAttribute('class', 'likeList');
$likeList.setAttribute('name', 'likeList');
$likeList.setAttribute('th:data-id', '${item.boardNum}');

$unchecked.setAttribute('class', 'fas fa-heart unchecked');
$checked.setAttribute('class', 'fas fa-heart checked');

// 3) 상위 컨테이너에 추가. 컨테이너 안에 자식 요소로 넣는다.
$label.appendChild($likeList);
$label.appendChild($unchecked);
$label.appendChild($checked);

[...whereBookmark].forEach(ele=>ele.appendChild($label.cloneNode(true)));

// 1) 지도 만들 때처럼 체크박스가 생성되기 전엔 없다. 상위 컨테이너에 리스너를 위임 등록한다.
const $bookmark = document.querySelectorAll('.likeList');
$bookmark.forEach(ele => {
 //체크박스가 체크/해제 되었을 때 이벤트 로직 처리.
  ele.addEventListener('change', isChecked_f);
});


function isChecked_f(e){
  // 이벤트가 먹히는지 확인
//  console.log(e);
  // 체크 된 것만 읽어오기
  const query = 'input[name="likeList"]:checked';
  const theChecked = document.querySelectorAll(query);
//  console.log(theChecked);

  // 체크된 곳의 dataset이 뭔지 읽어보자. 시퀀스값이 제대로 읽힐 것인가?
  // 서버 쪽 데이터를 읽으려면 우선 html에서 그 데이터가 심어진 곳을 타겟팅해야 한다
  // const $dataBox = document.querySelectorAll('.likeList');
  // const bbsIds = ($dataBox?.dataset.board)? $dataBox.dataset.board : '';
  // console.log(bbsIds);

}