import { randomUUID } from "crypto";

type InputProperties = {
    id?: string;
    type?: string;
    placeholder?: string;
    label?: string;
}

export default function Input({id, type, placeholder, label}:InputProperties){

    let defaultStyle = "transition bg-gray-300 text-lg rounded p-2 outline-none shadow-sm text-gray-900";
    let focusStyle = "focus:bg-white";

    let classStyles = [defaultStyle, focusStyle].join(" ");

    let input_id = id ?? [type, randomUUID()].join("-");

    return (
        <div className="flex flex-col mt-4">
            <label htmlFor={input_id} className="text-sm text-gray-400">{label}</label>
            <input id={input_id} className={classStyles} type={type} placeholder={placeholder}></input>
        </div>
    )

}