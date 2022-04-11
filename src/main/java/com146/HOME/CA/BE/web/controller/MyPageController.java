package com146.HOME.CA.BE.web.controller;

import com146.HOME.CA.BE.domain.mypage.DTO.*;
import com146.HOME.CA.BE.domain.mypage.SVC.MyPageSVC;
import com146.HOME.CA.BE.web.form.login.LoginMember;
import com146.HOME.CA.BE.web.form.mypage.LikeListForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageSVC myPageSVC;

    // 마이페이지 화면
    @GetMapping
    public String likeList(@ModelAttribute LikeListForm likeListForm,
                               HttpServletRequest request, Model model)
            throws IllegalStateException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);


        List<Like> list = myPageSVC.likeList();

        model.addAttribute("likeList", list);

        return "/mypage";

    }

    // 관심리스트 삭제
    @DeleteMapping("{likeNum}")
    public String delLike(@PathVariable Long likeNum) {

        myPageSVC.deleteLike(likeNum);

        return "redirect:/mypage";
    }

    // 구독/알림 목록
    @GetMapping("/subscribe")
    public String SubscribeList(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);

        List<Subscribe> list = myPageSVC.subscribeList();

        model.addAttribute("subscribeList", list);

        return "/mypage/subscribe";

    }

    // 알림 설정 수정 처리
    @PatchMapping("/subscribe")
    public String alarm(@PathVariable Long subNum,
                        @ModelAttribute int alarm,
                        RedirectAttributes redirectAttributes,
                        HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();

        Subscribe subscribe = new Subscribe();

        BeanUtils.copyProperties(alarm, subscribe);

        int modifiedSubscribe = myPageSVC.setAlarm(alarm);

        redirectAttributes.addAttribute("alarm", subscribe.getAlarmChk());

        return "redirect:/mypage/subscribe";

    }

    // 구독 취소
    @DeleteMapping("/subscribe/{subNum}")
    public String delSub(@PathVariable Long subNum) {

        myPageSVC.deleteSubscribe(subNum);

        return "redirect:/mypage/subscribe";
    }


    // 내가 작성한 게시물 목록
    @GetMapping("/board")
    public String myBoardList(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);

        List<MyBoard> list = myPageSVC.myBoardList();

        model.addAttribute("myBoardList", list);
        return "/mypage/board";

    }


    // 내가 작성한 댓글 목록
    @GetMapping("reply")
    public String myReplyList(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);

        List<MyReply> list = myPageSVC.myReplyList();

        model.addAttribute("myReplyList", list);
        return "/mypage/reply";

    }


    // 내가 신고한 게시물 목록
    @GetMapping("/boardReport")
    public String myBoardReport(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);

        List<MyBoardReport> list = myPageSVC.boardReportList();

        model.addAttribute("boardReportList", list);
        return "subscribe/list";

    }


    // 내가 신고한 댓글 목록
    @GetMapping("/replyReport")
    public String myReplyReport(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        LoginMember loginMember = (LoginMember) session.getAttribute("loginMember");
        String id = loginMember.getId();
        log.info(id);

        List<MyReplyReport> list = myPageSVC.replyReportList();


        model.addAttribute("replyReportList", list);
        return "/mypage/replyReport";

    }


}
