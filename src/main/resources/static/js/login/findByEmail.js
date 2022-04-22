    function div_show(selectList) {
      const $obj1 = document.getElementById("type1"); // 휴대폰으로 찾기
      const $obj2 = document.getElementById("type2"); // 이메일로 찾기
      // 휴대폰으로 찾기
      if (selectList == "0") {
        $obj1.style.display = "block";
        $obj2.style.display = "none";
      // 이메일로 찾기
      } else if (selectList == "1") {
        $obj1.style.display = "none";
        $obj2.style.display = "block";
      }
    }