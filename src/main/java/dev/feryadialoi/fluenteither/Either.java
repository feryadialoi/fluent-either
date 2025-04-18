package dev.feryadialoi.fluenteither;

import java.util.function.Function;

public sealed interface Either<L, R> permits Left, Right {

    static <L, R> Either<L, R> left(L value) {
        return new Left<>(value);
    }

    static <L, R> Either<L, R> right(R value) {
        return new Right<>(value);
    }

    default <TL, TR> Either<TL, TR> fold(Function<L, TL> leftMapper, Function<R, TR> rightMapper) {
        return switch (this) {
            case Left<L, R> left -> left(leftMapper.apply(left.value()));
            case Right<L, R> right -> right(rightMapper.apply(right.value()));
        };
    }

    default Object merge() {
        return switch (this) {
            case Left<L, R> left -> left.value();
            case Right<L, R> right -> right.value();
        };
    }

    default L left() {
        return switch (this) {
            case Left<L, R> left -> left.value();
            case Right<L, R> right -> throw new EitherException("Cannot get left value from right value");
        };
    }

    default R right() {
        return switch (this) {
            case Left<L, R> left -> throw new EitherException("Cannot get right value from left value");
            case Right<L, R> right -> right.value();
        };
    }

}
