"use client"

import { useState } from "react";
import { FaCheckCircle, FaInfoCircle } from "react-icons/fa";
type InputProperties = {
    id?: string;
    className?: string;
    type?: string;
    placeholder?: string;
    label?: string;
    maxLength?: number;
    minLength?: number;
}

export default function MyInput({ id, className, type, placeholder, label, maxLength, minLength }:InputProperties){

    const [value, setValue] = useState("");
    const [isValid, setValid] = useState(true);

    let label_text_class:Array<string> = [
        "transition-all",
        "text-sm",
        "cursor-pointer",
    ];
    let input_text_class:Array<string> = [
        "transition-all",
        "p-2",
        "outline-none",
        "text-sm",
        "border",
        "rounded-sm",
        "bg-slate-50",
        "focus:bg-white",
        "focus:ring",
        "focus:ring-2",
    ];

    const input_id = id ?? ``;

    const mask:any = {
        'cpf': (e:any) => {
            e.target.value = e.target.value.replace(/\D/g,"")                    //Remove tudo o que não é dígito
            e.target.value = e.target.value.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
            e.target.value = e.target.value.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
                                                                                 //de novo (para o segundo bloco de números)
            e.target.value = e.target.value.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
            verify_input.cpf(e);
        }
    }

    const verify_input:any = {
        'basic_validation': (e:any, is_valid:boolean) => {
            if(minLength && e.target.value.length < minLength)
                is_valid = false
            if(maxLength && e.target.value.length > maxLength)
                is_valid = false
            
            return is_valid;
        },
        'email': (e:any) => {
            let is_valid:boolean = false;
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.target.value))
            is_valid = true;
            else
            is_valid = false;
            is_valid = verify_input.basic_validation(e, is_valid);
            
            setValid(is_valid);
            setValue(e.target.value);
        },
        'text': (e:any) => {
            let is_valid:boolean = true;
            is_valid = verify_input.basic_validation(e, is_valid);

            setValid(is_valid);
            setValue(e.target.value);
        },
        'cpf': (e:any) => {
            let is_valid:boolean = true;
            is_valid = verify_input.basic_validation(e, is_valid);
            
            if(!(/^[0-9.-]$/.test(e.target.value))) is_valid = false;
            else is_valid = true;
            
            if(e.target.value.length != 14) is_valid = false;
            else is_valid = true;
            
            setValid(is_valid);
            setValue(e.target.value);
        }
    }

    const is_valid_input:Function = () => {

        if(value.length == 0){
            return "unset";
        }
        
        if(isValid){
            return "valid";
        }

        return "invalid";
    }

    const input_element:React.ReactNode = (() => {
        switch(type){
            case "text":
            case "email":
                return(
                    <>
                        { 
                            label ? 
                            <div className="flex py-1 gap-2 place-items-center">
                                <label htmlFor={input_id} className={`
                                    ${label_text_class.join(" ")}
                                    ${is_valid_input() == "unset" ? "text-gray-400 hover:text-gray-500" : ""}
                                    ${is_valid_input() == "valid" ? "text-green-400 hover:text-green-500" : ""}
                                    ${is_valid_input() == "invalid" ? "text-red-400 hover:text-red-500" : ""}
                                `}>{label}</label>
                                <FaInfoCircle 
                                    size={12} 
                                    className={`transition-all ${is_valid_input() == "invalid" ? "text-red-500" : "hidden text-transparent"}`} 
                                />
                                <FaCheckCircle 
                                    size={12}
                                    className={`transition-all ${is_valid_input() == "valid" ? "text-green-500" : "hidden text-transparent"}`} 
                                />
                            </div> : 
                            "" 
                        }
                        <input 
                            id={input_id}
                            type={type}
                            placeholder={placeholder}
                            onChange={(e) => { 
                                if(verify_input[type]){ 
                                    verify_input[type](e);
                                }
                            }}
                            className={`
                                ${input_text_class.join(" ")}
                                ${is_valid_input() == "unset" ? "focus:ring-blue-200" : ""}
                                ${is_valid_input() == "valid" ? "focus:ring-green-200" : ""}
                                ${is_valid_input() == "invalid" ? "focus:ring-red-200" : ""}
                            `}
                        />
                    </>
                )
            case "cpf":
                return(
                    <>
                        { 
                            label ? 
                            <div className="flex py-1 gap-2 place-items-center">
                                <label htmlFor={input_id} className={`
                                    ${label_text_class.join(" ")}
                                    ${is_valid_input() == "unset" ? "text-gray-400 hover:text-gray-500" : ""}
                                    ${is_valid_input() == "valid" ? "text-green-400 hover:text-green-500" : ""}
                                    ${is_valid_input() == "invalid" ? "text-red-400 hover:text-red-500" : ""}
                                `}>{label}</label>
                                <FaInfoCircle 
                                    size={12} 
                                    className={`transition-all ${is_valid_input() == "invalid" ? "text-red-500" : "hidden text-transparent"}`} 
                                />
                                <FaCheckCircle 
                                    size={12}
                                    className={`transition-all ${is_valid_input() == "valid" ? "text-green-500" : "hidden text-transparent"}`} 
                                />
                            </div> : 
                            "" 
                        }
                        <input 
                            id={input_id}
                            type="text"
                            maxLength={maxLength}
                            minLength={minLength}
                            placeholder={placeholder}
                            onChange={(e) => { 
                                if(verify_input[type]){ 
                                    verify_input[type](e);
                                } 
                            }}
                            onKeyDown={(e) => mask[type] ? mask[type](e) : false}
                            className={`
                                ${input_text_class.join(" ")}
                                ${is_valid_input() == "unset" ? "focus:ring-blue-200" : ""}
                                ${is_valid_input() == "valid" ? "focus:ring-green-200 border-green-200" : ""}
                                ${is_valid_input() == "invalid" ? "focus:ring-red-200 border-red-200" : ""}
                            `}
                        />
                    </>
                )
            default:
                return <></>
        }
    })()

    return (
        <div className="flex flex-col justify-start">
            { input_element }
        </div>
    )
}