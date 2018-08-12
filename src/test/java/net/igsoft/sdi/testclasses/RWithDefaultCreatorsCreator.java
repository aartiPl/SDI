package net.igsoft.sdi.testclasses;

import java.util.List;

import com.google.common.collect.Lists;

import net.igsoft.sdi.AutoCreator;
import net.igsoft.sdi.Creator;
import net.igsoft.sdi.InstanceCreator;

public class RWithDefaultCreatorsCreator extends Creator<R, RWithDefaultCreatorsCreatorParams> {
    @Override
    public R create(InstanceCreator instanceCreator,
                    RWithDefaultCreatorsCreatorParams parametrizedCreatorParams) {
        //Test that C, D and E are available
        D d = instanceCreator.getOrCreate(D.class);

        return new R(instanceCreator.getOrCreate(Stepper.class),
                     parametrizedCreatorParams.getName(), parametrizedCreatorParams.getSurname());
    }

    @Override
    public List<Creator<?, ?>> defaultCreators() {
        return Lists.newArrayList(new DCreator(), new AutoCreator(Stepper.class));
    }
}
