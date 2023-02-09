package com.zinzza.getinline.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorCodeTest {

    @ParameterizedTest(name = "[{index}] {0} =====> {1}")
    @MethodSource
    @DisplayName("예외를 받으면, 예외 메시지가 포함된 메시지 출력")
    void givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage(ErrorCode sut, String expected) {
        //given
        Exception e = new Exception("This is test message.");
        //when
        String actual = sut.getMessage(e);
        //then
        assertThat(actual.equals(expected));
    }

    static Stream<Arguments> givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage() {
        return Stream.of(
                Arguments.arguments(ErrorCode.OK, "Ok - this is test message."),
                Arguments.arguments(ErrorCode.BAD_REQUEST, "bad request - this is test message."),
                Arguments.arguments(ErrorCode.SPRING_BAD_REQUEST, "Spring-detected bad request - this is test message."),
                Arguments.arguments(ErrorCode.VALIDATION_ERROR, "Validation error - this is test message."),
                Arguments.arguments(ErrorCode.INTERNAL_ERROR, "internal error - this is test message."),
                Arguments.arguments(ErrorCode.SPRING_INTERNAL_ERROR, "Spring-detected internal error - this is test message."),
                Arguments.arguments(ErrorCode.DATA_ACCESS_ERROR, "Data Access Error - this is test message.")
        );
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" =====> \"{1}\"")
    @MethodSource
    @DisplayName("메시지를 받으면, 해당 에러 메시지로 출력")
    void givenMessage_whenGettingMessage_thenReturnsMessage(String input, String expected) {
        //given

        //when
        String actual = ErrorCode.INTERNAL_ERROR.getMessage(input);
        //then
        assertThat(actual.equals(expected));
    }

    static Stream<Arguments> givenMessage_whenGettingMessage_thenReturnsMessage() {
        return Stream.of(
                Arguments.arguments(null, ErrorCode.INTERNAL_ERROR.getMessage()),
                Arguments.arguments("", ErrorCode.INTERNAL_ERROR.getMessage()),
                Arguments.arguments("   ", ErrorCode.INTERNAL_ERROR.getMessage()),
                Arguments.arguments("This is test message.", ErrorCode.INTERNAL_ERROR.getMessage())
        );
    }

    @DisplayName("toString() 호출 포맷")
    @Test
    void givenErrorCode_whenToString_thenReturnsSimplifiedToString() {
        //given

        //when
        String result = ErrorCode.INTERNAL_ERROR.toString();
        //then
        assertThat(result.equals("INTERNAL_ERROR (20000)"));
    }

}
