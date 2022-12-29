package fishsim;

import java.util.List;

import engine.core.Update;
import engine.entity.Entity;
import fishsim.entities.passingobjects.PassingObject;

public class PassingObjectUpdater extends Update {

	public PassingObjectUpdater(int ups, List<Entity> entities) {
		super(ups, entities);
	}

	@Override
	public void update() {
		for (Entity e : entities) {
			if (e instanceof PassingObject)
				e.update();
		}
	}

}
