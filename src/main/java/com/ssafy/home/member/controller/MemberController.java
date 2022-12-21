package com.ssafy.home.member.controller;

import com.ssafy.home.apt.dto.AptLikeDTO;
import com.ssafy.home.apt.service.AptLikeService;
import com.ssafy.home.apt.service.AptService;
import com.ssafy.home.member.dto.MemberDto;
import com.ssafy.home.member.service.JwtService;
import com.ssafy.home.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class MemberController {
    public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;
    private final AptLikeService aptService;

    private final JwtService jwtService;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    public MemberController(MemberService memberService, AptLikeService aptService, JwtService jwtService) {
        this.memberService = memberService;
        this.aptService = aptService;
        this.jwtService = jwtService;
    }
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberDto memberDto) throws Exception {
        logger.info("{}",memberDto);
        //회원가입
        int result = memberService.join(memberDto);
        if(result == 1){
            return new ResponseEntity<String>("success",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/check")
    public ResponseEntity<?> duplicateCheckUserId(@RequestParam String userId) throws Exception {
        // 아이디 중복체크
        try{
            int result = memberService.duplicateCheckUserId(userId);
            logger.info("result = {}", result);
            if(result == 1){
                return new ResponseEntity<String>("unusable", HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("usable", HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody MemberDto memberDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
        	logger.info("member : {}", memberDto);
            MemberDto loginUser = memberService.login(memberDto);
            logger.info("loginUser = {}",loginUser);
            if (loginUser != null) {
                String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId());// key, data
                String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId());// key, data
                int result = memberService.saveRefreshToken(memberDto.getUserId(), refreshToken);
                logger.info("SaveRefreshToken result: {}", result);
                logger.info("로그인 accessToken 정보 : {}", accessToken);
                logger.info("로그인 refreshToken 정보 : {}", refreshToken);

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
    @GetMapping("/info/{userId}")
    public ResponseEntity<Map<String, Object>> getInfo(
            @PathVariable("userId")  String userId,
            HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
        System.out.println("userId = " + userId);
        System.out.println("token = " + request.getHeader("access-token"));
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        if (jwtService.checkToken(request.getHeader("access-token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
//				로그인 사용자 정보.
                MemberDto memberDto = memberService.userInfo(userId);

                //관심 매물 정보
                List<AptLikeDTO> likeList = aptService.getLikeList(userId);
                System.out.println(likeList.toString());
                resultMap.put("userInfo", memberDto);
                resultMap.put("aptLike", likeList);
                resultMap.put("message", SUCCESS);

                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
                e.printStackTrace();
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
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request)
            throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refresh-token");
        logger.info("token : {}, memberDto : {}", token, memberDto);
        if (jwtService.checkToken(token)) {
            if (token.equals(memberService.getRefreshToken(memberDto.getUserId()))) {
                String accessToken = jwtService.createAccessToken("userid", memberDto.getUserId());
                logger.info("token : {}", accessToken);
                logger.info("정상적으로 액세스토큰 재발급!!!");
                resultMap.put("access-token", accessToken);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            }
        } else {
            logger.info("리프레쉬토큰도 사용불!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    @GetMapping("/logout/{userid}")
    public ResponseEntity<?> removeToken(@PathVariable("userid") String userid) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            memberService.deleRefreshToken(userid);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);

    }
}
