package com.iteratrlearning.shu_book.chapter_05;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BusinessRuleEngineTest {

    /*
    * TDD의 주기는 다음을 따른다
    * 1.실패하는 테스트를 구현
    * 2.모든 테스트 실행
    * 3.기능이 동작하도록 코드 구현
    * 4.모든 테스트 실행
    * (4-1.리팩터링 -> 1번 으로)
    * */
    @Test
    void shouldHaveNoRulesInitialy(){
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    void shouldAddTwoAction(){
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction(){

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);

        // when
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        // then
        verify(mockAction).execute();
    }

}