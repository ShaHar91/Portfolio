package be.christiano.portfolio.app.data.mapper

import be.christiano.portfolio.app.data.local.entities.LinkEntity
import be.christiano.portfolio.app.data.remote.dto.LinkDto
import be.christiano.portfolio.app.domain.model.Link

fun LinkEntity.toLink() = Link(
    type,
    url
)

fun List<LinkEntity>.toLinks() = this.map { it.toLink() }

fun LinkDto.toLink() = Link(
    type,
    url
)

fun LinkDto.toLinkEntity(workId: String)= LinkEntity(
    workId = workId,
    type = type,
    url = url
)

fun List<LinkDto>.toEntities(workId: String) = this.map { it.toLinkEntity(workId) }

@JvmName("dtoToLinks")
fun List<LinkDto>.toLinks() = this.map { it.toLink() }
