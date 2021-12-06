package com.sandeep.Pasal.rasan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RasanService {

    private final RasanRepository rasanRepository;

    @Autowired
    public RasanService(RasanRepository rasanRepository) {
        this.rasanRepository = rasanRepository;
    }


    public List<Rasan> getRasans() {
        return rasanRepository.findAll();
    }

    public void addNewRasan(Rasan rasan) {
        Optional<Rasan> rasanByName = rasanRepository.findRasanBYName(rasan.getName());
        if (rasanByName.isPresent()) {
            throw new IllegalStateException("Item already added");
        }
        rasanRepository.save(rasan);
    }

    public void deleteRasan(Integer id) {
        boolean exists = rasanRepository.existsById(id);
        if (exists) {
            rasanRepository.deleteById(id);
        } else {
            throw new IllegalStateException(
                    "Item with name " + id + " does not exists"
            );
        }

    }

    @Transactional
    public void updateRasan(Integer number, String name, Integer price, Integer quantity){
        Rasan rasan  = rasanRepository.findById(number).orElseThrow(()-> new IllegalStateException(
                "Item with number" + number + " does not exist"));
        if (name != null && name.length() >0 && !Objects.equals(rasan.getName(),name) ){
            rasan.setName(name);

        }
        if (price != null && !Objects.equals(rasan.getPrice(),price) ){
            rasan.setPrice(price);

        }
        if (quantity != null && !Objects.equals(rasan.getQuantity(),quantity) ){
            rasan.setQuantity(quantity);

        }
    }
}
