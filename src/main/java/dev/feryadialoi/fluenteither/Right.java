package dev.feryadialoi.fluenteither;

public record Right<L, R>(R value) implements Either<L, R> {
}
