package com.cybermakers.gitrankingcommits.domain.services

import com.cybermakers.gitrankingcommits.domain.entities.GitUser

interface GitUserService {
    fun createGitUser(gitUser: GitUser): GitUser
}