package com.cybermakers.gitrankingcommits.application.web.controller

import com.cybermakers.gitrankingcommits.domain.entities.GitUser
import com.cybermakers.gitrankingcommits.domain.services.GitUserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("git")
class GitUserController(
    val gitUserService: GitUserService
) {

    @PostMapping("user")
    fun createGitUser(@Valid @RequestBody gitUser: GitUser,
                      uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<GitUser> {
        logger?.info("Requested create git user: ${gitUser.toString()}")

        val createdGitUser = this.gitUserService.createGitUser(gitUser)
        val uri = uriComponentsBuilder.path("/git/user/{nickname}").buildAndExpand(createdGitUser.nickname).toUri()

        return ResponseEntity.created(uri).body(createdGitUser)
    }

    companion object {
        val logger: Logger? = LoggerFactory.getLogger(GitUserController::class.java)
    }

    @GetMapping("/user/{nickname}")
    fun getByNickname(@PathVariable nickname: String): ResponseEntity<GitUser> {
        logger?.info("Requested git user using nickname: ${nickname}")
        return ResponseEntity.ok(this.gitUserService.getByNickname(nickname))
    }
}