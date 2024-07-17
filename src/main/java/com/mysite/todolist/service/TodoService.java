package com.mysite.todolist.service;

import com.mysite.todolist.model.Todo;
import com.mysite.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return todoRepository.findAll();    // 레포지토리에 모든 todo 불러오기
    }

    public void todoCreate(String content) {
        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCompleted(false);   // todo 객체를 처음 생성시 completed는 false로 설정
        todoRepository.save(todo);
    }

    public void todoDelete(Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "가 없습니다."));
        // todo에 레포지토리에서 해당 id를 찾아 값이 존재하지 않을 경우 메시지 출력
        // IllegalArgumentException : 잘못된 인수 값이 전달될 때 발생하는 예외

        todoRepository.delete(todo);    // 레포지토리에 todo 삭제
    }

    public void todoUpdate(Integer id, boolean completed) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "가 없습니다."));

        todo.setCompleted(completed);
        todoRepository.save(todo);
    }
}
