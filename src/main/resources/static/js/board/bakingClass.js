'use strict';
//네이버, 카카오 지도 API 사용 로직.

    // 지도생성시 초기 옵션 주기
    var mapOptions = {
        center: new naver.maps.LatLng(35.5352071674071, 129.31091449029512),
        zoom: 18,
        mapTypeId: naver.maps.MapTypeId.NORMAL
    };

    // 지도 그리기
    var map = new naver.maps.Map('map', mapOptions);

    // 마커생성하기
    var marker = new naver.maps.Marker({
      position: new naver.maps.LatLng(35.5352071674071, 129.31091449029512), //좌표값
      map: map, // 마커 표기할 지도

      // 네이버에서 제공하는 기본마커가 아닌 사용자 정의 마커 정의할때
      icon: {
          content: `<div class='mymarker'></div>`,
          //size: new naver.maps.Size(16, 16),   //마커 사이즈
          anchor: new naver.maps.Point(8, 8), //마커 중심좌표
      },
      //animation: naver.maps.Animation.BOUNCE
    });


    // 인포 창 생성
    var infowindow = new naver.maps.InfoWindow({
        content: `<div class='info'>hello</div>`,
        anchorSize : new naver.maps.Size(10,10)  //인포 창 뾰족이 크기
    });

    // 마커 클릭시
    naver.maps.Event.addListener(marker, "click", function(e) {
        // 인포창이 지도에 나타나 있으면 인포창 닫기
        if (infowindow.getMap()) {
            infowindow.close();
        // 인포창이 지도에 없으면 인포창 띄우기
        } else {

            infowindow.open(map, marker);
        }
    });



    //============================== 키워드 검색 =========================================

    // 1) 시군구 체크박스에 리스너를 달아 검색 함수를 실행. 체크박스 class와 name은 'subChk'.
    // 체크박스는 '만들어지기 전엔' 존재하지 않는다. 이벤트 위임 필요.
    subBox.addEventListener('change', getChks_f);

    // 2) 체크박스 체크 여부에 따른 키워드를 문자열로 읽어낸다.
    function getChks_f(){
      const query = 'input[name="subChk"]:checked';
      const chkBoxes = document.querySelectorAll(query);

      let keyword = '';
      chkBoxes.forEach(ele => {
        keyword += ele.value+' ';
      });
      // console.log(keyword);

      // 3) 추출한 키워드를 카카오api 검색함수에 매개값으로 넣고 돌림
      // 카카오 지도api는 여러 개의 검색어가 겹치면 먹통이 된다. 본질적 문제로 라디오 버튼 사용.
      const ps = new kakao.maps.services.Places();

      if( keyword.includes('전체') ){
        ps.keywordSearch( keyword.substring(0,2)+'베이킹 클래스', placesSearchCB);
      }else{
        ps.keywordSearch( keyword+'베이킹 클래스', placesSearchCB);
      }
    }

    // 대한민국 전체 범위 검색
    allCityBtn.addEventListener('click', searchAll_f);

    function searchAll_f(){
      const ps = new kakao.maps.services.Places();
      ps.keywordSearch('베이킹 클래스', placesSearchCB);
    }


    // 마커생성하기
    // parameter : 위도, 경도
    function makeMarker(lat,lng){

      const marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(lat,lng), //좌표값
        map: map, // 마커 표기할 지도

        // 네이버에서 제공하는 기본마커가 아닌 사용자 정의 마커 정의할때
        icon: {
            content: `<div class='mymarker'></div>`,
            //size: new naver.maps.Size(16, 16),   //마커 사이즈
            anchor: new naver.maps.Point(8, 8), //마커 중심좌표
        },
        //animation: naver.maps.Animation.BOUNCE
      });

      return marker;
    }


    // 인포창 생성하기
    // parameter : {상호명,연락처,부가정보,도로명주소}
    function makeInforWindow( info ){

      const infowindow = new naver.maps.InfoWindow({
        content:
          `<div class='info'>
            <div>상호명</div><div>${info.place_name}</div>
            <div>연락처</div><div>${info.phone}</div>
            <div>부가정보</div><div><a href='${info.place_url}' target='_blank'>${info.place_url}</a></div>
            <div>도로명주소</div><div>${info.road_address_name}</div>
          </div>`,
        // anchorSize : new naver.maps.Size(10,10)  //인포 창 크기
      });

      return infowindow;
    }

    const markers=[];
    const infos=[];

    // 키워드 검색 완료 시 호출되는 콜백함수
    function placesSearchCB (data, status, pagination) {

      // console.log(data);
      // console.log(status);
      // console.log(pagination);

      //검색전 마크존재시 지도에서 제거
      markers.forEach(marker=>marker.setMap(null));

      //검색전 인포창 지도에서 제거
      infos.forEach(info=>info.close());

      // 마커,인포 배열에서 제거
      markers.splice(0,markers.length);
      infos.splice(0,infos.length);

      switch (status) {

        case kakao.maps.services.Status.OK : //검색 결과 있음
            console.log(data);
            const result = data.splice(0,5);  // 검색어에 근접한 5개만 추출
            console.log(result);

            //지도에 마커 표시, 인포창 생성
            result.forEach(ele => {

              let marker = makeMarker(ele.y, ele.x)
              markers.push(marker);

              let infowindow = makeInforWindow(
                {
                  place_name : ele.place_name,  //상호명
                  phone : ele.phone,            //연락처
                  place_url : ele.place_url,    //부가정보
                  road_address_name : ele.road_address_name //도로명주소
                }
              )
              infos.push(infowindow);
            });

            const lats =[]; //경도
            const lngs =[]; //위도
            //마커 클릭시 인포창 띄우기
            markers.forEach( (marker, idx) => {
              naver.maps.Event.addListener(marker, 'click', e=>{
                // 인포창이 지도에 나타나 있으면 인포창 닫기
                if (infos[idx].getMap()) {
                  infos[idx].close();
                // 인포창이 지도에 없으면 인포창 띄우기
                } else {
                  infos[idx].open(map, marker);
                }
              });
              lats.push(marker.position.y);
              lngs.push(marker.position.x);
            });

            //위도,경도 최대 최소 구하기
            const minLat = Math.min.apply(null,lats);
            const minLng = Math.min.apply(null,lngs);
            const maxLat = Math.max.apply(null,lats);
            const maxLng = Math.max.apply(null,lngs);

            //좌표경계구하기
            const target = new naver.maps.LatLngBounds(
              new naver.maps.LatLng(minLat, minLng),
              new naver.maps.LatLng(maxLat, maxLng));

            //지도 중심 좌표 이동
            map.panToBounds(target);

            break;
        case kakao.maps.services.Status.ZERO_RESULT  : //정상적으로 응답 받았으나 검색 결과는 없음
          alert('검색 결과가 없습니다.');
          break;
        case kakao.maps.services.Status.ERROR   : //서버 응답에 문제가 있는 경우
          alert('서버 응답에 문제가 있습니다.');
          break;
        default:
        alert('기타');
          break;
      }









    }



