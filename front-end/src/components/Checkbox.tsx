
type CheckboxProperties = {
    name?: string;
}

export default function Checkbox({ name }:CheckboxProperties){

    return (
        <div className="flex place-items-center">
            <input className="mr-2" id="checkbox" type="checkbox"></input>
            <label htmlFor="checkbox" className="text-gray-800 text-sm">{name}</label>
        </div>
    )

}