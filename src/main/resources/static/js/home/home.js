'use strict';
// 헤더 내려오기
$(function(){
    const depth1 = $(".menu > li"),
          header = $("header");

    depth1.mouseenter(function(){
        header.stop().animate({height:"500px"});
    }).mouseleave(function(){
        header.stop().animate({height:"100px"});
    })
    console.log('클릭됨');
}); //ready

//member on/off
const $memberBtn = document.querySelector(".memberBtn");
$memberBtn?.addEventListener("click", e=> {

    const $container_member = document.querySelector(".container_member");
    if($container_member.style.display=="none"){
        $container_member.style.display = "flex";
    }else{
        $container_member.style.display = "none";
    }
});

// 검색창 on/off
const $searchBtn = document.querySelector(".searchBtn");
$searchBtn?.addEventListener("click", e=> {

    const $container_search = document.querySelector(".container_search");
    if($container_search.style.display=="none"){
        $container_search.style.display = "block";
    }else{
        $container_search.style.display = "none";
    }
});