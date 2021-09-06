package ru.lunchVote.service;

// Sweets
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lunchVote.models.Cafe;
import ru.lunchVote.models.Menu;
import ru.lunchVote.repository.MenuRepository;

@Service
@Transactional(readOnly = true)
public class MenuService {

    private final MenuRepository menuRepository;
    private final CafeService cafeService;

    public MenuService(MenuRepository menuRepository, CafeService cafeService){
        this.menuRepository = menuRepository;
        this.cafeService = cafeService;
    }

    public Menu getMenu(int cafeId) {
        int id = cafeService.get(cafeId).getMenuId();
        return menuRepository.findById(id).get();
    }

    @Transactional
    public Menu createAndSaveMenu(int cafeId, Menu menu) {
        menuRepository.save(menu);
        Cafe cafe = cafeService.get(cafeId);
        cafe.setMenuId(menu.getId());
        cafeService.updateMenu(cafe);
        return menu;
    }
}
