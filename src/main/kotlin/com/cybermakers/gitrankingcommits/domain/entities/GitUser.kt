package com.cybermakers.gitrankingcommits.domain.entities

import lombok.*
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Data
@Builder
@ToString
data class GitUser(
    @Min(10)
    @NotNull
    val name: String,

    @Min(5)
    @NotNull
    @NotEmpty
    val nickname: String,

    @Min(10)
    @NotNull
    @NotEmpty
    val githubUrl: String,
)
