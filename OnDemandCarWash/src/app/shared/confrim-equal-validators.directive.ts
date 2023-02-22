import { Directive, Input } from "@angular/core";
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from "@angular/forms";
@Directive({
    selector: '[appConfrimEqualValidator]',
    providers: [{
        provide: NG_VALIDATORS,
        useExisting: ConfrimEqualValidatorsDirective,
        multi: true
    }]

}) 
export class ConfrimEqualValidatorsDirective  implements Validator{
    @Input()
    appConfrimEqualValidator!: string;
    validate(control: AbstractControl<any, any>): {[key:string]:any} | null {
        const controlToCompare=control.parent?.get(this.appConfrimEqualValidator);
        if(controlToCompare && controlToCompare.value != control.value){
         return { 'notEqual':true};
        }
        return null;
    }
    
   

}