import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.danp_mvvm.data.model.Painting

@Dao
interface PaintingDao {
    suspend fun getAllPaintings(): List<Painting>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(paintings: List<Painting>)
}
