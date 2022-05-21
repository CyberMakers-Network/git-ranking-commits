package com.cybermakers.gitrankingcommits.domain.repositories

import com.cybermakers.gitrankingcommits.domain.entities.GitUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GitUserRepository : MongoRepository<GitUser, UUID> {
    fun getByNickname(nickname: String): GitUser?
}