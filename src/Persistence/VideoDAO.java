package Persistence;

import Entities.Video;

public class VideoDAO extends DAO{

    public VideoDAO() {

    }

    public void savevideo(Video video) throws Exception {
        try {
            if (video == null) {
                throw new Exception("video can't be null");
            }
            String sql = "INSERT INTO videos (idvideo, author, isAvailable, Duration) "
                    + "VALUES ( " + video.getId()+ " , '" + video.getAuthor()
                    + "' ,'" + video.isAvaliable() + "','" + video.getDuration() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void deleteVideo(Video video) throws Exception {
        try {
            if (video == null) {
                throw new Exception("video  can't be null");
            }
            String sql = "DELETE FROM videos WHERE userId = " + video.getId();
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }





}
