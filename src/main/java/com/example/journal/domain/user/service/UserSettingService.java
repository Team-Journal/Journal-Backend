package com.example.journal.domain.user.service;

import com.example.journal.domain.post.domain.Posts;
import com.example.journal.domain.post.exception.PostAccessDeniedException;
import com.example.journal.domain.user.domain.User;
import com.example.journal.domain.user.domain.repository.UserRepository;
import com.example.journal.domain.user.exception.UserNotFoundException;
import com.example.journal.domain.user.facade.UserFacade;
import com.example.journal.domain.user.present.dto.request.UpdateIntroRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSettingService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void IntroUpdate(UpdateIntroRequest request){
        User currentUser = userFacade.getCurrentUser();

        User user = userRepository.findByAccountId(currentUser.getAccountId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.updateIntro(request.getIntro());

        userRepository.save(user);
    }
}
