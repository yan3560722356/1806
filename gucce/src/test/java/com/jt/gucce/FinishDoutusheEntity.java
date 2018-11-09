package com.jt.gucce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName(value="doutusheEntity")
public class FinishDoutusheEntity implements Pipeline<DoutusheEntity>{
	
	@Override
	public void process(DoutusheEntity doutusheEntity) {
		String title = doutusheEntity.getTitle();
		String images=doutusheEntity.getImgList().toString();
		System.out.println("\n\n抓到的标题"+doutusheEntity.getTitle());
		System.out.println("\n\n抓到的图片列表"+doutusheEntity.getImgList().toString());
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement("insert into doutu(title,images) values(?,?)");
			ps.setString(1, title);
			ps.setString(2, images);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
