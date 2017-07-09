package wolf.zero.litepal;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author sineom
 * @version 1.0
 * @time 2017/7/8 16:53
 * @des ${TODO}
 * @updateAuthor ${Author}
 * @updataTIme 2017/7/8
 * @updataDes ${描述更新内容}
 */

public interface ApiService {

    @GET("top250")
    Observable<ResultMovieBean<List<ResultMovieBean.SubjectsEntity>>> doGet(@Query("start") int start,
                                                                            @Query("count") int count);
}

