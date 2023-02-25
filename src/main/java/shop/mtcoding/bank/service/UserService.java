package shop.mtcoding.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.bank.dto.user.JoinReqDto;
import shop.mtcoding.bank.handler.ex.CustomException;
import shop.mtcoding.bank.model.user.UserRepository;

@Service // IoC
public class UserService {
    @Autowired // DI
    private UserRepository userRepository;

    @Transactional // 회원가입 메서드 호출이 시작될때, 트랜잭션 시작, 끝날때, 트랜잭션 종료(commit : 영구히 기록되는 것)
    public void 회원가입(JoinReqDto joinReqDto) {
        // mybatis는 인수(joinReqDto)로 들어온 오브젝트의 변수명으로 자동 매핑해준다.
        // (mybatis는 DTO의 변수의 getter를 호출해서 값을 찾는다)
        int result = userRepository.insert(joinReqDto);
        if (result != 1) {
            throw new CustomException("회원가입 실패",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}