package Patrones;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.ClanSombra;
import com.mygdx.game.Consumibles;
import com.mygdx.game.JimboAdventures;
import com.mygdx.game.Snake;
import com.mygdx.game.Superficies;
import com.mygdx.game.TorretasLevel;

import Utils.LevelType;

public interface Builder {
	public void setConsumibles(Consumibles consu);
	public void setClanSombra(ClanSombra clan);
	public void setSuperficies(Superficies sup);
	public void setTorretas(TorretasLevel torretas);
	public void setWorld(World world);
	public void setFondo(Texture img);
	public void setJimbo(Jimbo jimbo, float x, float y, int health, int balas);
	public void setGame(JimboAdventures game);
	public void setLevelType(LevelType lvlType);
	public void setSnake(Snake snake);
	public void setMusic(String name);
}
