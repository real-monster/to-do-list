package au.edu.swin.sdmd.todolist

import androidx.room.TypeConverter
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class ToDoTypeConverter {
    @TypeConverter
    fun fromZonedDateTime(dateTime: ZonedDateTime): Long {
        return dateTime.toInstant().toEpochMilli()
    }

    @TypeConverter
    fun toZonedDateTime(millisSinceEpoch: Long): ZonedDateTime {
        return ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(millisSinceEpoch),
            ZoneId.systemDefault()
        )
    }


}