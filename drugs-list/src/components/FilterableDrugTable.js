import React, { useState, useCallback, memo } from 'react';

import { ControlBar } from './main/ControlBar';
import { DrugTable } from './main/DrugTable';
import { DrugWindow } from './modal/DrugWindow';
import { DrugInfoWindow } from './modal/DrugInfoWindow';

import { useForm } from '../hooks/useForm';

export const FilterableDrugTable = memo(({ drugs: initialDrugs }) => {
    const [drugs, setDrugs] = useState(initialDrugs.concat());
    const [filteredDrugs, setFilteredDrugs] = useState(initialDrugs.concat());
    const [modalWindowTitle, setModalWindowTitle] = useState('Dodaj lek');
    const [drugInfoWindowTitle, setDrugInfoWindowTitle] = useState('');
    const [drugInfo, setDrugInfo] = useState({});
    const [submitBtnText, setSubmitBtnText] = useState('Dodaj');
    const [exisitngId, setExisitngId] = useState(-1);
    const [limitBelow, setLimitBelow] = useState(0);
    const [limitAbove, setLimitAbove] = useState(Number.POSITIVE_INFINITY);

    const [drugForm, change, setDrugForm, resetDrugForm] = useForm({
        name: '',
        price: 0,
        description: '',
        imageUrl: '',
        producer: '',
        sub1name: '',
        sub1amount: 0,
        sub2name: '',
        sub2amount: 0,
        sub3name: '',
        sub3amount: 0,
        formulation: '',
        drugEffect: ''
    });

    const removeSortSigns = () => {
        const thElems = document.getElementsByClassName('sortableColumn');
        
        for (let i = 0; i < thElems.length; i++) {
            let thElem = thElems[i];
            thElem.classList.remove('headerSortDown');
            thElem.classList.remove('headerSortUp');
        }
    }

    const resetPriceInput = () => {
        document.getElementById('priceFromInput').value = '';
        document.getElementById('priceToInput').value = '';
    }

    const deleteDrug = useCallback((drugId) => {
        removeSortSigns();
        resetPriceInput();
        const newDrugs = drugs.filter(drug => drug.id !== drugId);
        setDrugs(newDrugs);
        setFilteredDrugs(newDrugs);
    }, [ drugs ]);

    const addDrug = useCallback((drug) => {
        removeSortSigns();
        resetPriceInput();
        const orderedDrugs = drugs.sort((a, b) => (a.id - b.id));

        const newId = Math.max(...drugs.map(d => d.id)) + 1 === Number.NEGATIVE_INFINITY ? 1 : Math.max(...drugs.map(d => d.id)) + 1;

        const newDrugs = orderedDrugs.concat({
            ...drug,
            id: newId,
        });

        setDrugs(newDrugs);
        setFilteredDrugs(newDrugs);
    }, [ drugs ]);

    const replaceDrug = useCallback((drug) => {
        removeSortSigns();
        const actualDrugs = drugs.concat();
        const drugIndex = actualDrugs.findIndex(d => d.id === drug.id);
        actualDrugs[drugIndex] = drug;
        setDrugs(actualDrugs);
        setFilteredDrugs(actualDrugs);
    }, [ drugs ]);

    const showFormAddDrug = () => {
        setExisitngId(-1);
        resetDrugForm();
        showAllErrors();
        setModalWindowTitle('Dodaj nowy lek');
        setSubmitBtnText('Dodaj');
    };

    const showAllErrors = () => {
        let errors = document.getElementsByClassName('error');

        for(let i = 0; i < errors.length; i++) {
            errors[i].classList.remove('hideErrorDiv');
        }
    };

    const showFormEditDrug = useCallback((drugId) => {
        const drug = drugs.find(d => d.id === drugId);
        setExisitngId(drugId);
        setDrugForm(drug);
        hideAllErrors();
        setModalWindowTitle('Edytuj lek: ' + drug.name);
        setSubmitBtnText('Zatwierdź');
    }, [ drugs, setDrugForm ]);

    const hideAllErrors = () => {
        let errors = document.getElementsByClassName('error');

        for(let i = 0; i < errors.length; i++) {
            errors[i].classList.add('hideErrorDiv');
        }
    };

    const showInfoDrugWindow = (drugId) => {
        const drug = drugs.find(d => d.id === drugId);
        setDrugInfo(drug);
        setDrugInfoWindowTitle('Karta leku: ' + drug.name);
    };

    const filterDrugsByPrice = useCallback((backLimitBelow, backLimitAbove) => {
        removeSortSigns();

        if(backLimitAbove === '') {
            setLimitAbove(Number.POSITIVE_INFINITY);
        } else {
            setLimitAbove(backLimitAbove);
        }

        setLimitBelow(backLimitBelow);

        const limitedDrugs = drugs.filter(drug => drug.price >= limitBelow && drug.price <= limitAbove);
        setFilteredDrugs(limitedDrugs);
    }, [ drugs, limitBelow, limitAbove ]);

    return (
        <div className="container">
            <ControlBar showFormAddDrug={ showFormAddDrug } filterDrugsByPrice={ filterDrugsByPrice } limitBelow={ limitBelow } limitAbove={ limitAbove } />
            <DrugTable drugs={ filteredDrugs } setDrugs={ setFilteredDrugs } onDeleteDrug={ deleteDrug } showFormEditDrug={ showFormEditDrug }
                showInfoDrugWindow={ showInfoDrugWindow } removeSortSigns={ removeSortSigns } />
            <DrugWindow exisitngId={ exisitngId } onAddDrug={ addDrug } onEditDrug={ replaceDrug } submitBtnText={ submitBtnText } 
                modalWindowTitle={ modalWindowTitle } drugForm={ drugForm } change={ change } />
            <DrugInfoWindow drug={ drugInfo } modalWindowTitle={ drugInfoWindowTitle } />
        </div>
    );
});