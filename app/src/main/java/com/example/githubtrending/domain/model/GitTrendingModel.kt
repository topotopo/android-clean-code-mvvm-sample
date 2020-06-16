package com.example.githubtrending.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitTrendingModel(
    @PrimaryKey var url: String,
    var author: String?,
    var name: String?,
    var avatar: String?,
    var description: String?,
    var language: String?,
    var languageColor: String?,
    var stars: String?,
    var forks: String?,
    var currentPeriodStar: String?
)