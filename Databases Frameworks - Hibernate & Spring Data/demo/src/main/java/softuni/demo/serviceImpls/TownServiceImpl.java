package softuni.demo.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import softuni.demo.dto.TownDto;
import softuni.demo.entities.Town;
import softuni.demo.repositories.TownRepository;
import softuni.demo.services.TonwService;
import softuni.demo.util.ModelParser;

public class TownServiceImpl implements TonwService {
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void addTown(TownDto town) {
        Town entity = ModelParser.getInstance().map(town, Town.class);
        townRepository.saveAndFlush(entity);
    }
}
