package com.wiki.jumpspring.Question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wiki.jumpspring.DataNotFoundException;
import com.wiki.jumpspring.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    // public List<Question> getList() {
        // return this.questionRepository.findAll();
    // }

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        // Pageable pageable = PageRequest.of(page,10);
        Pageable pageable = PageRequest.of(page,10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        // isPresent메소드로 해당 데이터가 존재하는지 검사.
        if(question.isPresent()) {
            return question.get();
        }else{
            // id 값에 해당하는 question 데이터가 없을 경우 메세지 발생.
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content,SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    
}
