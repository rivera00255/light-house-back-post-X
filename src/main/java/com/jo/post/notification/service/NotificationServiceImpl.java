package com.jo.post.notification.service;

import com.jo.post.notification.model.Notification;
import com.jo.post.notification.model.NotificationDto;
import com.jo.post.notification.reppository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository noticeRepository;

    @Override
    public void saveNotice(NotificationDto noticeDto) {
        try {
            noticeRepository.save(Notification.builder()
                    .title(noticeDto.getTitle())
                    .content(noticeDto.getContent())
                    .build());
        } catch (Exception e) {
            log.error("save notice error: {}", e.getMessage());
        }
    }

    @Override
    public List<Notification> findAllNotice() {
        try {
            return noticeRepository.findAll();
        } catch (Exception e) {
            log.error("find all notice error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Notification> findById(Long id) {
        try {
            return Optional.ofNullable(noticeRepository.findById(id).get());
        } catch (Exception e) {
            log.error("find by notice id error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void editNotice(Long id, NotificationDto noticeDto) {
        try {
            Notification notice = noticeRepository.getById(id);

            if(notice != null) {
                notice.setTitle(noticeDto.getTitle());
                notice.setContent(noticeDto.getContent());
            }

            noticeRepository.save(notice);
        } catch (Exception e) {
            log.error("edit notice error: {}", e.getMessage());
        }
    }

    @Override
    public void delNotice(Long id) {
        try {
            if(noticeRepository.findById(id).isPresent()) {
                noticeRepository.deleteById(id);
            }
        } catch (Exception e) {
            log.error("delete notice error : {}", e.getMessage());
        }
    }
}
