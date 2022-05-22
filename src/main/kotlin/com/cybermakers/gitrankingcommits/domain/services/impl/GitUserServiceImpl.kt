package com.cybermakers.gitrankingcommits.domain.services.impl

import com.cybermakers.gitrankingcommits.domain.entities.GitUser
import com.cybermakers.gitrankingcommits.domain.exceptions.GitUserServiceException
import com.cybermakers.gitrankingcommits.domain.repositories.GitUserRepository
import com.cybermakers.gitrankingcommits.domain.services.GitUserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GitUserServiceImpl(
    private val gitUserRepository: GitUserRepository
) : GitUserService {

    override fun createGitUser(gitUser: GitUser): GitUser {
        logger?.info("Create user: ${gitUser.nickname}")

        this.gitUserRepository.getByNickname(gitUser.nickname)?.let {
            logger?.error("User ${gitUser.nickname} already registered.")
            throw GitUserServiceException("User already registered.")
        }

        logger?.info("User ${gitUser.nickname} has been successfully registered.")
        return gitUserRepository.save(gitUser)
    }

    override fun getByNickname(nickname: String): GitUser {
        this.gitUserRepository.getByNickname(nickname)?.let {
            return it
        }

        throw GitUserServiceException("Nickname no registered on us service.")
    }

    companion object {
        private val logger: Logger? = LoggerFactory.getLogger(GitUserService::class.java)
    }
}