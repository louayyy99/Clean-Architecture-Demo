package com.blc.domain.sample.model

import com.google.gson.annotations.SerializedName

data class SampleModel (
    @SerializedName("name") val name: String,
    @SerializedName("description") val description:String
)
