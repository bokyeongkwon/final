package com146.HOME.CA.BE.web.controller;

import com146.HOME.CA.BE.domain.login.Login;
import com146.HOME.CA.BE.domain.login.svc.LoginSVC;
import com146.HOME.CA.BE.domain.member.Member;
import com146.HOME.CA.BE.domain.member.svc.MemberSVC;
import com146.HOME.CA.BE.web.form.login.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
//@RequestMapping("/login")
public class LoginController {

//  private final MemberSVC memberSVC;
  private final LoginSVC loginSVC;

  /**
   * 로그인
   * @param model
   * @return
   */
  @GetMapping("/login")
  public String loginForm(Model model){
    model.addAttribute("loginForm",new LoginForm());
    return "login/loginForm";

  }

  /**
   * 로그인처리
   * @param loginForm
   * @param bindingResult
   * @param redirectUrl
   * @return
   */
  @PostMapping("/login")
  public String login(
          @Valid
          @ModelAttribute LoginForm loginForm,
          BindingResult bindingResult,
          @RequestParam(name="redirectUrl",defaultValue = "/") String redirectUrl,
          Model model,
          HttpServletRequest request){

    //필드유효성 체크
    if(bindingResult.hasErrors()){
      log.info("loginError={}", bindingResult);
      return "login/loginForm";
    }
//    //회원유무 체크
//    if(!memberSVC.exitMember(loginForm.getId())){
//      bindingResult.reject("loginFail.id");
//      return "login/loginForm";
//    }
    //로그인 체크
    Login login = loginSVC.login(loginForm.getId(),loginForm.getPw());
    if(login == null){
      bindingResult.reject("loginFail.pw");
      return "login/loginForm";
    }

    //로그인 성공
    HttpSession httpSession = request.getSession(true);
    //로그인 정보
    LoginMember loginMember = new LoginMember(login.getId(),login.getPw());
    httpSession.setAttribute("loginMember", loginMember);
    //URL 재요청
    return "redirect:/";

    //자동로그인설정
    //아직안함
  }

  /**
   * 카카오로그인
   * @return
   */
  @RequestMapping(value="/login/kakaoLogin")
  public String kakaoLogin() {
    StringBuffer loginUrl = new StringBuffer();
    loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
    loginUrl.append("f2f1fba2f863bd6c7452dc44fc18562c");
    loginUrl.append("&redirect_uri=");
    loginUrl.append("https://localhost:9080/kakaoLogin");
    loginUrl.append("&response_type=code");

    return "redirect:"+loginUrl.toString();
  }


  /**
   * 아이디 찾기 양식(전화번호)
   * @return
   */
  @GetMapping("/findTelID")
  public String findTelIDForm(){

    return "login/findTelID";
  }

  /**
   * 아이디 찾기 처리(전화번호)
   * @return
   */
  @PostMapping("/findTelID")
  public String findTelID(){

    return "login/findTelIDResult";
  }

//  /**
//   * 아이디 찾기 처리(전화번호)
//   * @param findTelID
//   * @param model
//   * @return
//   */
//  @PostMapping("/findTelID")
//  public String findTelID(
//          @ModelAttribute FindTelID findTelID, Model model){
//    Login telIDs = loginSVC.searchTelID(findTelID.getName(),findTelID.getTel());
//    model.addAttribute("telIDs",telIDs);
//    return "login/findTelIDResult";
//  }

  /**
   * 아이디찾기(이메일)
   * @return
   */
  @GetMapping("/findEmailID")
  public String findEmailID(){

    return "login/findEmailID";
  }

//  /**
//   * 아이디 찾기 처리(이메일)
//   * @param findEmailID
//   * @param model
//   * @return
//   */
//  @PostMapping("/findEmailID")
//  public String findEmailID(
//          @ModelAttribute FindEmailID findEmailID, Model model){
//    Login emailIDs = loginSVC.searchTelID(findEmailID.getName(),findEmailID.getEmail());
//    model.addAttribute("telIDs",emailIDs);
//    return "login/findTelIDResult";
//  }

  /**
   * 비밀번호 찾기(휴대폰)
   * @return
   */
  @GetMapping("/findTelPW")
  public String findTelPWForm(){

    return "login/findTelPW";
  }

//  /**
//   * 비밀번호 찾기 처리(전화번호)
//   * @param findTelPW
//   * @param httpServletRequest
//   * @param model
//   * @return
//   */
//  @PostMapping("findTelPW")
//  public String findTelPW(
//          @ModelAttribute FindTelPW findTelPW,
//          HttpServletRequest httpServletRequest,
//          Model model){
//
//
//    return "redirect:/login/findTelPW";
//  }

  /**
   * 비밀번호 찾기(이메일)
   * @return
   */
  @GetMapping("/findEmailPW")
  public String findEmailPWForm(){

    return "login/findEmailPW";
  }

//  /**
//   * 비밀번호 찾기 처리(이메일)
//   * @param findEmailPW
//   * @param httpServletRequest
//   * @param model
//   * @return
//   */
//  @PostMapping("findEmailPW")
//  public String findEmailPW(
//          @ModelAttribute FindEmailPW findEmailPW,
//          HttpServletRequest httpServletRequest,
//          Model model){
//
//
//    return "redirect:/login/findEmailPW";
//  }


  /**
   * 로그아웃
   * @param request
   * @return
   */
  @GetMapping("/logout")
  public String logout(HttpServletRequest request){

    //있으면 반환하고 없으면 null 반환
    HttpSession httpSession = request.getSession(false);
    if(httpSession != null){
      httpSession.invalidate();
      log.info("세션없응");
    }
    return "redirect:/";
  }



}
