package Persistence;

import Entities.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoDAO extends DAO<Video>{

    public VideoDAO() {}

    @Override
    public void save(Video video) throws Exception {
        try {
            if (video == null) {
                throw new Exception("video can't be null");
            }
            String sql = "INSERT INTO videos (idVideo, author, isAvailable, Duration) "
                    + "VALUES ( '" + video.getId()+ "' , '" + video.getAuthor()
                    + "' ,'" + (video.isAvaliable()?1:0) + "','" + video.getDuration() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void delete(Video video) throws Exception {
        try {
            if (video == null) {
                throw new Exception("video  can't be null");
            }
            String sql = "DELETE FROM videos WHERE idVideo = '" + video.getId() + "'";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void update(Video video, String lastId) throws Exception {
        try {
            if (video == null) {
                throw new Exception("Video can't be null");
            }
            String sql = "UPDATE videos SET " +
                    "idVideo = '" + video.getId() +"', author ='" + video.getAuthor() + "', duration = " + video.getDuration() +
                    " WHERE idVideo = '" + lastId + "';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
    }

    @Override
    public Video getById(String id) throws Exception {
        Video video = new Video();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM videos WHERE idVideo = '" + id +"';";
            consultDB(sql);
            while (resultSet.next()) {
                video.setId(resultSet.getString(2));
                video.setAuthor(resultSet.getString(3));
                video.setAvaliable(resultSet.getInt(4) == 1);
                video.setDuration(resultSet.getInt(5));
            }
            return video;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
        return null;
    }

    @Override
    public List<Video> getList() throws Exception {
        ArrayList<Video> videos= new ArrayList<>();
        try {
            String sql = "SELECT * FROM videos";
            consultDB(sql);

            while (resultSet.next()) {
                Video video = new Video();
                video.setId(resultSet.getString(2));
                video.setAuthor(resultSet.getString(3));
                video.setAvaliable(resultSet.getInt(4) == 1);
                video.setDuration(resultSet.getInt(5));
                videos.add(video);
            }
            return videos;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void updateVideoIsAvailable(Video video, String id) throws Exception {
        try {
            if (video == null) {
                throw new Exception("Video can't be null");
            }
            int isAvailable = (video.isAvaliable()?1:0);
            String sql = "UPDATE videos SET " +
                    "isAvailable = " + isAvailable +
                    " WHERE idVideo = '" + id + "';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
    }
}
