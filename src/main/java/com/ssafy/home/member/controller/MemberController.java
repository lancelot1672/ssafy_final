package com.ssafy.home.member.controller;

import com.ssafy.home.member.dto.MemberDto;
import com.ssafy.home.member.service.JwtService;
import com.ssafy.home.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    public MemberController(MemberService memberService, JwtService jwtService) {
        this.memberService = memberService;
        this.jwtService = jwtService;
    }
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberDto memberDto) throws Exception {
        System.out.println(memberDto);

        //회원가입
        int result = memberService.join(memberDto);
        if(result == 1){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody MemberDto memberDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            MemberDto loginUser = memberService.login(memberDto);
            System.out.println("loginUser = " + loginUser);
            if (loginUser != null) {
                String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId());// key, data
                String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId());// key, data
                memberService.saveRefreshToken(memberDto.getUserId(), refreshToken);
//                logger.debug("로그인 accessToken 정보 : {}", accessToken);
//                logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
//            logger.error("로그인 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @GetMapping("/info/{userid}")
    public ResponseEntity<Map<String, Object>> getInfo(
            @PathVariable("userid")  String userid,
            HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        if (jwtService.checkToken(request.getHeader("access-token"))) {
//            logger.info("사용 가능한 토큰!!!");
            try {
//				로그인 사용자 정보.
                MemberDto memberDto = memberService.userInfo(userid);
                resultMap.put("userInfo", memberDto);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
//            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
