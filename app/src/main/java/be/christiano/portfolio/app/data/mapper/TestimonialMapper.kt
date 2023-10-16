package be.christiano.portfolio.app.data.mapper

import be.christiano.portfolio.app.data.local.entities.TestimonialEntity
import be.christiano.portfolio.app.data.remote.dto.TestimonialDto
import be.christiano.portfolio.app.domain.model.Testimonial

fun TestimonialEntity.toTestimonial() = Testimonial(
    id,
    image,
    fullName,
    function,
    review
)

fun List<TestimonialEntity>.toTestimonials() = this.map { it.toTestimonial() }

fun TestimonialDto.toTestimonial() = Testimonial(
    id,
    image,
    fullName,
    function,
    review
)

fun TestimonialDto.toTestimonialEntity() = TestimonialEntity(
    id,
    image,
    fullName,
    function,
    review
)

fun List<TestimonialDto>.toEntities() = this.map { it.toTestimonialEntity() }
@JvmName("dtoToTestimonials")
fun List<TestimonialDto>.toTestimonials() = this.map { it.toTestimonial() }