package dev.feryadialoi.fluenteither;

public record Left<L, R>(L value) implements Either<L, R> {
}
