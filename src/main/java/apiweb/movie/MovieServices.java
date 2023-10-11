package apiweb.movie;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired
    private IMovieRepository _movieRepository;

    public MovieServices(IMovieRepository _movieRepository){
        this._movieRepository = _movieRepository;
    }
    public List<Movie> getMovies(){
        return _movieRepository.findAll();
    }
    public Optional<Movie> getMovie(String imdbId){
        return _movieRepository.findByImdbId(imdbId);
    }
}
